package com.javarush.jira.bugtracking.task;

import com.javarush.jira.bugtracking.Handlers;
import com.javarush.jira.bugtracking.task.to.TaskTo;
import com.javarush.jira.bugtracking.task.to.TaskToFull;
import com.javarush.jira.common.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = TaskTagController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskTagController {

    public static final String REST_URL = "/api/tags";
    private final TaskTagService taskTagService;

    //  get tasks by tag names
    @GetMapping("/tasks")
    public List<Long> getTasksForTagNames(@RequestParam List<String> tags) {
        log.info("get tasks by tagnames={}", tags);
        return taskTagService.getAllTasksForTagNames(tags);
    }

    //  get tag names by task
    @GetMapping("/{taskId}")
    public List<String> getTagNamesByTask(@PathVariable long taskId) {
        log.info("get all tags for task {}", taskId);
        return taskTagService.getAllTagsForTask(taskId);
    }

    //  update tags for task
    @PatchMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTagsForTask(@PathVariable long taskId, @RequestBody List<String> tags) {
        log.info("update tags for task={}", taskId);
        taskTagService.updateTagsForTask(taskId, tags);
    }

}
