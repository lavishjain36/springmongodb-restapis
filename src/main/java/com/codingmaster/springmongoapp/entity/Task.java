package com.codingmaster.springmongoapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    private  String taskId;
    private  String description;
    private  int severity;
    private  String assignee;
    private  int storyPoint;

}
