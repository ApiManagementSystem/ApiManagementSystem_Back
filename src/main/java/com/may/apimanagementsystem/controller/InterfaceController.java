package com.may.apimanagementsystem.controller;

import com.may.apimanagementsystem.dto.ResponseEntity;
import com.may.apimanagementsystem.po.Interfaces;
<<<<<<< HEAD
import com.may.apimanagementsystem.po.Project;
=======
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
import com.may.apimanagementsystem.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import javax.annotation.Resource;
=======
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
import java.util.List;

import static com.may.apimanagementsystem.constant.ExceptionMessage.SUCCESS;

@RestController
@RequestMapping("interface")
public class InterfaceController {

    @Autowired
    private InterfaceService interfaceService;

    @PostMapping
    public ResponseEntity<Interfaces> addInterface(Interfaces interfaces){
        interfaceService.addInterface(interfaces);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

    @GetMapping("projectInterface")
    public ResponseEntity<List<Interfaces>> showInterface(int projectId){
        List<Interfaces> interfaces = interfaceService.getInterfaces(projectId);
        return new ResponseEntity<>(200,SUCCESS,interfaces);
    }

    @DeleteMapping("{interfaceId}")
    public ResponseEntity<Interfaces> deleteInterface(@PathVariable int interfaceId){
        interfaceService.removeInterface(interfaceId);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

    @PutMapping("{interfaceId}")
<<<<<<< HEAD
    public ResponseEntity<Interfaces> updateInterface(@PathVariable int interfaceId,Interfaces interfaces){
=======
    public ResponseEntity<Interfaces> updateInterface(@PathVariable int interfaceId, Interfaces interfaces){
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
        interfaceService.updateInterface(interfaces);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

    @GetMapping("{interfaceId}")
<<<<<<< HEAD
    public ResponseEntity<Interfaces> getInterfaceByInterfaceId(@PathVariable int interfaceId,Interfaces interfaces){
        interfaceService.getInterfaceByInterfaceId(interfaceId);
        return new ResponseEntity<>(200,SUCCESS,interfaces);
    }
=======
    public ResponseEntity<Interfaces> getInterfaceByInterfaceId(@PathVariable int interfaceId, Interfaces interfaces){
        interfaceService.getInterfaceByInterfaceId(interfaceId);
        return new ResponseEntity<>(200,SUCCESS,interfaces);
    }

    @RequestMapping("{projectId}")
    public ResponseEntity<Interfaces> downloadInterface(@PathVariable int projectId){
        interfaceService.getInterfaceByInterfaceId(projectId);
        return new ResponseEntity<>(200,SUCCESS,null);
    }
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
}
