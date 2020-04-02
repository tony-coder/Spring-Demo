package spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.data.SpittleRepository;
import spittr.domain.Spittle;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {  // 注入SpittleRepository
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittle(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) Long max,  // 因为查询参数都是String类型的，因此defaultValue属性需要String类型的值
            @RequestParam(value = "count", defaultValue = "20") int count
            , Model model) {
        // 当调用addAttribute()方法并且不指定key的时候，那么key会根据值的对象类型推断确定，例如List<Spittle>会被推断为spittleList
        // model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));  // 将spittle添加到模型中
        // return "spittles";  // 返回视图名

        // 当处理器方法返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出，在本例中是spittleList
        return spittleRepository.findSpittles(max, count);  // 逻辑视图的名称将会根据请求路径推断得出，因为这个方法处理针对"/spittles"的GET请求，因此视图的名称将会是spittles
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
