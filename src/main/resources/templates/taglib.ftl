<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Freemarker Guide</title>
</head>

<body>
    <h1>Welcome!!</h1>
    <h2>freemarker 함수로만 작성</h2>
    <h4>
        <#if notNullValue?has_content>
            ${notNullValue}
        </#if>
    </h4>
    <h4>
        <#if nullValue?has_content>
            ${nullValue}
        </#if>
    </h4>


    <h2>TagLibrary로 작성</h2>
    <h4>
        ${taglib.getValueOrEmpty(notNullValue)}
    </h4>
    <h4>
        ${taglib.getValueOrEmpty(nullValue)}
    </h4>
</body>

</html>