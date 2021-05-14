package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @ApiOperation("Buscar todas las compras")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Buscar una compra a traves de su id")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable("purchaseId") Long purchaseId){
        return ResponseEntity.of(purchaseService.getPurchase(purchaseId));
    }

    @ApiOperation("Buscar una compra a traves del id de su cliente")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("clientId") String clientId){
        return ResponseEntity.of(purchaseService.getByClient(clientId));
    }

    @ApiOperation("Guardar una compra nueva")
    @ApiResponse(code = 200, message = "OK")
    @PostMapping()
    public ResponseEntity save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

    @ApiOperation("Eliminar una compra a traves de su id")
    @ApiResponse(code = 200, message = "OK")
    @DeleteMapping("/{purchaseId}")
    public ResponseEntity delete(@PathVariable("purchaseId") Long purchaseId){
        if(purchaseService.delete(purchaseId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
