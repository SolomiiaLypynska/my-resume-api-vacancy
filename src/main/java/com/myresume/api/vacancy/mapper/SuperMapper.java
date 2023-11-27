package com.myresume.api.vacancy.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public interface SuperMapper<E, D> {
    D toDto(E entity);

    E toEntity(D dto);

    default List<D> toDto(Collection<E> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    default List<E> toEntity(List<D> fieldDtos) {
        return fieldDtos.stream().map(this::toEntity).toList();
    }

    default <T extends Describable> String map(T value) {
        return Objects.nonNull(value) ? value.getDescription() : "";
    }
}
