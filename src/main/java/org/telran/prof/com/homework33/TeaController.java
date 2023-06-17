package org.telran.prof.com.homework33;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TeaController {

    private List<Tea> teas = new ArrayList<>();

    public TeaController() {
        teas.addAll(
                List.of(
                        new Tea("Ahmad"),
                        new Tea("TET"),
                        new Tea("Lipton"),
                        new Tea("Dilmah"),
                        new Tea("Bubble Tea")));
    }

    // Получение списка видов чая
    @GetMapping("/teas")
    public List<Tea> getTeas() {
        return teas;
    }

    // Запись из передаваемого формата JSON в наш список
    @PostMapping("/teas/new_tea")
    public Tea putNewTeaInAList(@RequestBody Tea tea) {
        teas.add(tea);
        return tea;
//        Можно также вернуть идентификатор,если поменять в сигнатуре
//        return tea.getUuid();
    }

    // Решила сделать все методы, которые рассматривали, чтобы повторить и разобрать все самостоятельно.
    // Удаление из списка по его уникальному UUID
    @DeleteMapping("/teas/{uuid}")
    public void deleteOneTea(@PathVariable String uuid) {
        teas.removeIf(tea -> tea.getUuid().equals(uuid));
    }

    // Замена значения по указанному идентификатору на тот, что мы передаем.
    @PutMapping("/teas/{uuid}")
    public Tea renewTeaInfo(@PathVariable String uuid, @RequestBody Tea tea) {
        for (Tea currentTea : teas) {
            if (currentTea.getUuid().equals(uuid)) {
                currentTea.setNameOfTea(tea.getNameOfTea());
                return currentTea;
            }
        }
        return null;
    }
}
