/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.lang.reflect.Method;

/**
 *
 * @author sergio
 */
public class Conversor<T> {
    
    public T convert(Object obj, Class classe) throws Exception {
        T instancia = (T)classe.newInstance();

        Method[] methods = obj.getClass().getDeclaredMethods();
        for(Method m : methods) {
            //se é getter
            //  procurar setter em T com o tipo de retorno do getter
            //      copiar valor de obj para T
            if( m.getName().startsWith("get") ) {
                String prop = m.getName().substring(3);
                if( prop.endsWith("Collection") ) {
                    continue;
                }
                Class ret = m.getReturnType();
                try {
                    Method setter = instancia.getClass().getMethod("set"+prop, ret);
//                    System.out.println("a converter "+prop);
                    setter.invoke(instancia, m.invoke(obj));
                } catch(Exception e) {
//                    System.out.println("CONVERT: "+e.getMessage());
                }
            }
        }
        
        return instancia;
    }
    
}
