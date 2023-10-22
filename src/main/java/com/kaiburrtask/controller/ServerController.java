package com.kaiburrtask.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kaiburrtask.model.ServerObj;
import com.kaiburrtask.service.ServerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerService service;

    @PostMapping
    public ServerObj createServer(@RequestBody ServerObj server){
        return service.addServer(server);
    }

    @GetMapping
    public List<ServerObj> getServers(){
        return service.getAllServers();
    }

    @GetMapping("/{serverId}")
    public ServerObj getServer(@PathVariable String serverId){
        return service.getServerByServerId(serverId);
    }

    @GetMapping("/name/{name}")
    public List<ServerObj> getServerByName(@PathVariable String name){
        return service.getServerByServerName(name);
    }

    @PutMapping
    public ServerObj updateServer(@RequestBody ServerObj serverRequest) {
        return service.updateServer(serverRequest);
    }

    @DeleteMapping("/{serverId}")
    public String deleteServer(@PathVariable String serverId){
        return service.deleteServer(serverId);
    }

}
