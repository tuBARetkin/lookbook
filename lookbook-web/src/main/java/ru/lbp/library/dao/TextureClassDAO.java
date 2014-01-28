/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.dao;

import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.TextureClass;

/**
 *
 * @author gorelov-n
 */
@Repository
public class TextureClassDAO extends ElementDAO<TextureClass>
{ 
    public TextureClassDAO(){
        super(TextureClass.class);
    }
}
