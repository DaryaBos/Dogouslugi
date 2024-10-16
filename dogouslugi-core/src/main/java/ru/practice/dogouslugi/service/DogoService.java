package ru.practice.dogouslugi.service;

import org.springframework.stereotype.Service;
import ru.practice.dogouslugi.dao.CategoryRepository;
import ru.practice.dogouslugi.dao.DogoServiceRepository;
import ru.practice.dogouslugi.model.Category;
import ru.practice.dogouslugi.model.DogoServiceEntity;
import ru.practice.dogouslugi.request.RequestId;

import java.util.LinkedList;
import java.util.List;

@Service
public class DogoService {
    private final DogoServiceRepository dogoServiceRepository;
    private final CategoryRepository categoryRepository;

  public DogoService(DogoServiceRepository dogoServiceRepository, CategoryRepository categoryRepository) {
    this.dogoServiceRepository = dogoServiceRepository;
    this.categoryRepository = categoryRepository;
  }

  /**
     * Получение списка всех сервисов
     *
     * @return - список сервисов
     */
    public List<DogoServiceEntity> listServices() {
        List<DogoServiceEntity> entityList = new LinkedList<>();
        Iterable<DogoServiceEntity> serviceEntities = dogoServiceRepository.findAll();
        serviceEntities.forEach(entityList::add);
        return entityList;
    }

    /**
     * Получение сервиса по его id
     *
     * @param request - запрос с id сервиса
     * @return искомый сервис
     */
    public DogoServiceEntity getServiceById(RequestId request) {
        DogoServiceEntity result = null;
        DogoServiceEntity serviceEntity = dogoServiceRepository.findByServiceId(request.getId());
        if (serviceEntity != null)
            result = serviceEntity;
        return result;
    }

    /**
     * получение списка категорий
     *
     * @return список категорий
     */
    public List<Category> listCategories() {
        List<Category> result = new LinkedList<>();
        Iterable<Category> categories = categoryRepository.findAll();
        categories.forEach(result::add);
        return result;
    }
}
