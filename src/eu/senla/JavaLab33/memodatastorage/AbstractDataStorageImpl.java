package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.AbstractDataStorage;
import eu.senla.JavaLab33.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AbstractDataStorageImpl<T extends BaseEntity> implements AbstractDataStorage<T> {

    private long entityIdSequence;

    private List<T> entities;

    @Override
    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    @Override
    public List<T> getEntities() {
        return entities;
    }

    @Override
    public long generateEntityId() {
        return entityIdSequence++;
    }

    @Override
    public T create(T entity) {
        entity.setId(generateEntityId());
        entities.add(entity);
        return entity;
    }
}
