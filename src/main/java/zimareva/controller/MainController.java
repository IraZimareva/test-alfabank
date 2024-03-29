package zimareva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zimareva.model.transferJSON.RequestJSON;
import zimareva.service.ItemService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/test")
public class MainController {

    private final ItemService itemService;

    @Autowired
    public MainController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseBody
    public List<BigInteger> getIdsByIdsAndColor(@RequestBody final RequestJSON requestJSON) {
        return itemService.getIdsByJSON(requestJSON);
    }
}
