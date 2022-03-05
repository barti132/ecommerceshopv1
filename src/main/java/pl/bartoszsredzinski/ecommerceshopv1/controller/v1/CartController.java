package pl.bartoszsredzinski.ecommerceshopv1.controller.v1;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.bartoszsredzinski.ecommerceshopv1.dto.CartDto;
import pl.bartoszsredzinski.ecommerceshopv1.dto.CartItemRequest;
import pl.bartoszsredzinski.ecommerceshopv1.service.CartService;

/**
 * Cart rest controller
 *
 * @author Bartosz Średziński
 * created on 03.03.2022
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cart")
public class CartController{

    private final CartService cartService;

    @GetMapping("/{login}")
    public CartDto getCartData(@PathVariable String login){
        log.info("GET cart/" + login);
        return cartService.getCartData(login);
    }

    @PostMapping("/{login}/addItem")
    public void addItemToUserCart(@RequestBody CartItemRequest cartItem, @PathVariable String login){
        log.info("POST cart/" + login + "/adItem");
        cartService.addItemToCart(login, cartItem);
    }

    @DeleteMapping("/{login}/all")
    public void deleteUserCart(@PathVariable String login){
        log.info("DELETE cart/" + login + "/all");
        cartService.deleteUserCart(login);
    }

    @DeleteMapping("/{login}/cartItem/{id}")
    public void deleteCartItem(@PathVariable String login, @PathVariable Integer id){
        log.info("DELETE cart/" + login + "/cartItem/" + id);
        cartService.deleteCartItemFromUserCart(login, id);
    }
}
