<div class="item row">
    <div class="image col-xs-5 col-sm-4 col-md-3 col-lg-2">
        <img src="/pizza_image/${cart_item.product.id}" class="img-responsive" alt="" />
    </div>
    <div class="content col-xs-7 col-sm-8 col-md-9 col-lg-10">
        <h3><a class="header" href="/products/${cart_item.product.id}">${cart_item.product.name}</a></h3>
        <div class="extra">
            <p><strong>Price: </strong>${cart_item.product.price} ₽ / each</p>
            <p><strong>Quantity: </strong>${cart_item.quantity}</p>
            <p class="total-sum"><strong>Total: </strong><span class="red">${cart_item.product.price * cart_item.quantity} ₽</span></p>
            <form action="/cart/change_quantity/${cart_item.id}" method="post" class="inline-block">
                <div class="ui action input">
                    <input type="number" class="cart-amount-input" name="quantity" placeholder="Amount">
                    <button class="ui blue button">Change Quantity</button>
                </div>
            </form>
            &nbsp;
            <form action="/cart/remove/${cart_item.id}" method="post" class="inline-block">
                <button type="submit" class="ui inverted red button">
                    <i class="remove icon"></i>
                    Remove
                </button>
            </form>
        </div>
    </div>
</div>