package com.dagudo.series_app_backend.dao;

import java.util.Collection;

public interface GeneroDao {

    public Collection<String> getGeneroBySerie(Integer idSerie);
}
