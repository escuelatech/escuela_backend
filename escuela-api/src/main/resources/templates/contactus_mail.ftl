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
<img src="cid:logo.jpg" style="display: block;" width="500" height="250" />
</div>
        </@layout.myLayout>