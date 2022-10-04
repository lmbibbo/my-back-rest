package com.luisma.mybackend.service.implementation;

import com.luisma.mybackend.enumeration.Status;
import com.luisma.mybackend.model.Server;
import com.luisma.mybackend.repository.ServerRepository;
import com.luisma.mybackend.service.ServerService;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@Transactional
public class ServerServiceImpl implements ServerService{

    private final ServerRepository serverRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ServerServiceImpl.class); 

    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public Server create(Server server) {
        log.info("Serving Server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
    
        return serverRepository.save(server);
    }

    private String setServerImageUrl() {
        String [] imageNames = { "server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toString();
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by Id {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating Server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Server by Id: {}", id);
        serverRepository.deleteById(id);
        return true;
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pingin Server IP: {}", ipAddress);  
        Server server= serverRepository.findByIpAddress(ipAddress);
        InetAddress address= InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000)? Status.SERVER_UP: Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }
    
}
