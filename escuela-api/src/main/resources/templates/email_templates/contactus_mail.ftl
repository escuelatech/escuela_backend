<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
<div>
<h3>${greeting}</h3>

<h3>
    We have received your enquiry.
</h3>
<p>
    ${message.message}
</p>
<br/>
<p>
    ${message.ack}
</p>
<br>
<img src="cid:logo.jpg" style="display: block;" width="200" height="150" />
</div>
        </@layout.myLayout>