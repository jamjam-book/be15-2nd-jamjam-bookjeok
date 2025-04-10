package com.jamjam.bookjeok.domains.order.service.cart;

import com.jamjam.bookjeok.domains.order.dto.cart.response.CartBookListResponse;
import com.jamjam.bookjeok.domains.order.dto.cart.response.CartResponse;
import com.jamjam.bookjeok.domains.order.dto.cart.request.CartRequest;

public interface CartService {

    CartResponse createBookToCart(CartRequest cartRequest);

    CartResponse modifyBookQuantity(CartRequest cartRequest);

    void deleteBookFromCartByMemberId(CartRequest cartRequest);

    CartBookListResponse getBooksInCart(Long memberUid);

}