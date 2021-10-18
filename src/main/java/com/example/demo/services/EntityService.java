package com.example.demo.services;

import java.util.List;


public interface EntityService<t>{
    public t saveEntity(t entity);
    public List<t> getEntity();
}
