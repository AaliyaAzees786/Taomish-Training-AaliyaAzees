package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private final List<Greeting> greetings = new ArrayList<>();

    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetings;
    }

    @PostMapping("/greetingPost")
    public Greeting createGreeting(@RequestBody GreetingRequest request) {
        int index = greetings.size();
        Greeting newGreeting = new Greeting(index, request.name());
        greetings.add(newGreeting);
        return newGreeting;
    }

    @PutMapping("/greeting/{index}")
    public ResponseEntity<String> updateGreeting(@PathVariable int index, @RequestBody GreetingRequest request) {
        if (index < 0 || index >= greetings.size()) {
            return ResponseEntity.badRequest().body("Invalid index for update");
        }
        greetings.set(index, new Greeting(index, request.name()));
        return ResponseEntity.ok("Greeting updated successfully");
    }

    @PatchMapping("/greeting/{index}")
    public ResponseEntity<String> patchGreeting(@PathVariable int index, @RequestBody GreetingRequest request) {
        if (index < 0 || index >= greetings.size()) {
            return ResponseEntity.badRequest().body("Invalid index for patching");
        }
        Greeting existingGreeting = greetings.get(index);
        greetings.set(index, new Greeting(index, request.name() != null ? request.name() : existingGreeting.content()));
        return ResponseEntity.ok("Greeting patched successfully");
    }

    @DeleteMapping("/greeting/{index}")
    public ResponseEntity<GenericResponse> deleteGreeting(@PathVariable int index) {

        GenericResponse genericResponse = new GenericResponse();

        if (index < 0 || index >= greetings.size()) {
            genericResponse.setMessage("Bad request received !");
            return ResponseEntity.badRequest().body(genericResponse);
        }
        greetings.remove(index);

        // Re-indexing after deletion
        for (int i = 0; i < greetings.size(); i++) {
            greetings.set(i, new Greeting(i, greetings.get(i).content()));
        }

        genericResponse.setData(greetings);
        genericResponse.setMessage("entry deleted successfully");

        return ResponseEntity.ok(genericResponse);
    }
}
