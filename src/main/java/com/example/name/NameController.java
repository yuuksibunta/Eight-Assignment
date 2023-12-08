package com.example.name;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    private final NameMapper nameMapper;

    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names")
    public List<Name> findByNames(@RequestParam(required = false) String startsWith) {
        if (startsWith == null) {
            // startsWith パラメータが提供されない場合のデフォルト値やオプションの処理を実装
            // この例では null を指定した場合、全ての名前を取得するなどの処理を行うことが考えられます。
            return nameMapper.findAllNames();
        } else {
            return nameMapper.findByNameStartingWith(startsWith);
        }
    }
}
