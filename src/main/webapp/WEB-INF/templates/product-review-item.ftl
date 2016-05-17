<div class="ui comments product-review-item">
    <div class="comment">
        <div class="content">
            <a class="author">${review.user.email}</a>
            <div class="metadata">
                <div class="date">${review.createdAt}</div>
                <div class="rating">
                    <i class="star icon"></i>
                    ${review.rating} Stars
                </div>
            </div>
            <div class="text">
                ${review.text}
            </div>
        </div>
    </div>
    <hr/>
</div>