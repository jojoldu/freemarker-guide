package com.example;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jojoldu@gmail.com on 2016-07-30.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value="/index/error")
    public String highError(Model model) {
        model.addAttribute("msg", getRandomData());
        return "index";
    }

    private String getRandomData() {
        if((int) (Math.random() * 10) > 4){
            return "Good Result";
        }

        return null;
    }

    private String template(String templateName, Map<String, Object> data) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
        try {
            Template template = cfg.getTemplate(templateName+".ftl");
            Writer out = new StringWriter();
            template.process(data, out);
            return out.toString();

        }catch (Exception e){
            return "";
        }

    }

    @RequestMapping(value="/index2/error")
    public String highError2(Model model) throws Exception {
        Map<String, Object> highData = new LinkedHashMap<>();
        highData.put("msg", getRandomData());

        model.addAttribute("high", template("high", highData));
        model.addAttribute("low", template("low", new LinkedHashMap<>()));
        return "index2";
    }

    @RequestMapping(value = "/taglib")
    public String taglib(Model model) throws Exception {
        model.addAttribute("notNullValue", "Null이 아니에요");
        model.addAttribute("nullValue", null);
        model.addAttribute("taglib", new TagLibrary());
        return "taglib";
    }

}
