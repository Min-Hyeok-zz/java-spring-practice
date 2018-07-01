package tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.mapper.Board;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/board/*")
public class BoardController {

    @Autowired
    Board board;

    @GetMapping(value = {"/", "", "/list"})
    public List board () {
        List list = board.GetAll();
        return list;
    }

    @GetMapping("/{idx}")
    public HashMap boardGet (@PathVariable int idx) {
        HashMap data = board.Get(idx);
        return data;
    }

    @PostMapping("/")
    public String boardPost (@RequestParam HashMap params) {
        System.out.println(params);
        board.Insert(params);
        return "true";
    }

    @PutMapping("/{idx}")
    public String boardPut (@RequestBody HashMap params, @PathVariable int idx) {
        System.out.println("params :"+params);
        System.out.println("idx :"+idx);
        params.put("idx", idx);
        board.Update(params);
        return "true";
    }

    @DeleteMapping("/{idx}")
    public String boardDelete (@PathVariable int idx) {
        System.out.println("idx :"+idx);
        board.Delete(idx);
        return "true";
    }
}
