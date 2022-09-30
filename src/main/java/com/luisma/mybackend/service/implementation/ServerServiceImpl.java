package com.luisma.mybackend.service.implementation;

import com.luisma.mybackend.model.Server;
import com.luisma.mybackend.repository.ServerRepository;
import com.luisma.mybackend.service.ServerService;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServerServiceImpl implements ServerService{

    private final ServerRepository serverRepository;
    
    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public Server create(Server server) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Server> list(int limit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server update(Server server) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server ping(String ipAddress) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
