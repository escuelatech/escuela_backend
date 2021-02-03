<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
    <div>
        <h3>${greeting}</h3>

        <h3>
            Thank you for registering for our training.
        </h3>
        <p>
            ${message.message}
        </p>
        <br/>
        <p>
            ${message.ack}
        </p>
        <br>
        <img src="cid:aws.jpg" style="display: block;" width="200" height="150" />
    </div>
</@layout.myLayout>