package org.apache.aoo.cmisucp.unobojects;

import com.sun.star.beans.Property;
import com.sun.star.beans.PropertyAttribute;
import com.sun.star.beans.UnknownPropertyException;
import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.WeakBase;
import com.sun.star.uno.Type;
import java.util.List;


public final class CMISPropertySetInfo extends WeakBase
   implements com.sun.star.beans.XPropertySetInfo
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = CMISPropertySetInfo.class.getName();
    private List<Property> available_properties;
    
    public CMISPropertySetInfo( XComponentContext context )
    {
        m_xContext = context;
        addProperties();
    };

    //My method
    private void addProperties()
    {
        available_properties.add(new Property("Title", -1, Type.STRING, (short)0));
        available_properties.add(new Property("IsFolder",-1,Type.BOOLEAN,PropertyAttribute.READONLY));
        available_properties.add(new Property("IsDocument", -1, Type.BOOLEAN, PropertyAttribute.READONLY));
        available_properties.add(new Property("DateCreated", -1, Type.VOID, PropertyAttribute.READONLY));
        available_properties.add(new Property("DateModified",-1,Type.VOID, PropertyAttribute.READONLY));
        available_properties.add(new Property("Size", -1, Type.LONG, PropertyAttribute.READONLY));
        available_properties.add(new Property("MediaType", -1,Type.STRING, PropertyAttribute.READONLY));
        available_properties.add(new Property("ContentType", -1, Type.STRING, PropertyAttribute.READONLY));
        available_properties.add(new Property("ID", -1, Type.STRING, PropertyAttribute.READONLY));
    }            
    
    // com.sun.star.beans.XPropertySetInfo:
    public com.sun.star.beans.Property[] getProperties()
    {
        return (Property[]) available_properties.toArray();
    }

    public com.sun.star.beans.Property getPropertyByName(String aName) throws com.sun.star.beans.UnknownPropertyException
    {
        for(Property p:available_properties)
            if(p.Name.equalsIgnoreCase(aName))
                return p;
        
        throw new UnknownPropertyException(aName+" Not found");
    }

    public boolean hasPropertyByName(String Name)
    {
        for(Property p:available_properties)
            if(p.Name.equalsIgnoreCase(Name))
                return true;
        
        return false;
    }

}
