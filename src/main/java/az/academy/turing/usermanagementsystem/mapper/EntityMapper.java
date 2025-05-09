package az.academy.turing.usermanagementsystem.mapper;

import java.util.List;

public interface EntityMapper<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
    List<E> toEntity(List<D> dtoList);
    List<D> toDtoList(List<E> entityList);
}
