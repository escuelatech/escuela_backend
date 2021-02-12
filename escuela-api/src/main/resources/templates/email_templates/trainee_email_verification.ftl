<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
    <div>
        <h3>${greeting}</h3>
        <p>
            Welcome to Escuela Technologies, thanks for your registration in our training platform.
        </p>
        <p>
            ${message.message}
            <img src="cid:aws.jpg" style="display: block;" width="100" height="100" />
        </p>
        <p>
            ${message.ack}
        </p>
        </br>
        <p> Join our training chat group <a href="https://chat.whatsapp.com/LeNx5tTdBM3GoOZDSqSKTJ">
            <img src="cid:watsapp.png" style="display: block;" width="100" height="100" /></a>
        </p>
        <br>
        <p>
        <img src="cid:logo.jpeg" style="display: block;" width="50" height="50" />Escuela Technologies
        </p>
    </div>
</@layout.myLayout>