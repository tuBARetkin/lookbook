/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.dao;

import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.Texture;

/**
 *
 * @author gorelov-n
 */
@Repository
public class TextureDAO extends ElementDAO<Texture>
{ 
    public TextureDAO(){
        super(Texture.class);
    }
}

