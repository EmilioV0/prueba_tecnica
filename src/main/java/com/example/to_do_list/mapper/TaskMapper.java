package com.example.to_do_list.mapper;

import com.example.to_do_list.dto.Detail;
import com.example.to_do_list.dto.GetTask;
import com.example.to_do_list.dto.ListTask;
import com.example.to_do_list.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "state", ignore = true)
    })
    public abstract Task toTask(Detail detail);

    @Mappings({
            @Mapping(source = "title", target = "detail.title"),
            @Mapping(source = "description", target = "detail.description")
    })
    public abstract GetTask toGetTask(Task task);
    public ListTask toListTask(Task task) {
        String title = task.getTitle();
        String description = task.getDescription();
        String status = ( task.getState() ? "completed" : "failed" );

        Detail detail = new Detail(title, description);

        return new ListTask( detail, status);
    }

    public abstract List<ListTask> toListTasks(List<Task> tasks);


}
