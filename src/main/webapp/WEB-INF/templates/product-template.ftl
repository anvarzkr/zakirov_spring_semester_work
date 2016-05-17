<div class="product-item col-md-3 col-sm-4 col-xs-6 text-center">
    <a href="/products/${product.id}">
        <img src="/pizza_image/${product.id}" class="product-item-image" alt="" />
    </a>
    <a href="/products/${product.id}" class="product-item-title">
        ${product.name}
    </a>
    <div class="product-item-price">
        ${product.price} ₽
    </div>
    <form action="/cart/add/${product.id}" method="post">
        <button class="ui big button green product-button-cart">
            <i class="fa fa-shopping-cart"></i>
            <span>
                Add to Cart
            </span>
        </button>
    </form>
</div>