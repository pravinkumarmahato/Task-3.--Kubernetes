package com.kaiburrtask.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiburrtask.model.ServerObj;
import com.kaiburrtask.repository.ServerRepository;

@Service
public class ServerService {

    @Autowired
    private ServerRepository repository;

    public ServerObj addServer(ServerObj server) {
        return repository.insert(server);
    }

    public List<ServerObj> getAllServers(){
        return repository.findAll();
    }

    public ServerObj getServerByServerId(String serverId){
        return repository.findById(serverId).get();
    }

    public List<ServerObj> getServerByServerName(String name){
        return repository.findByName(name);
    }

    public ServerObj updateServer(ServerObj serverRequest) {
        ServerObj existingServer = repository.findById(serverRequest.getId()).get();
        existingServer.setName(serverRequest.getName());
        existingServer.setLanguage(serverRequest.getLanguage());
        existingServer.setFramework(serverRequest.getFramework());
        return repository.save(existingServer);
    }

    public String deleteServer(String serverId){
        repository.deleteById(serverId);
        return "Server " + serverId + " deleted successfully";
    }

}
