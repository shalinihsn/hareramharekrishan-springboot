package harekrishan.all.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CustomCacheEventLogger implements CacheEventListener<Object, Object>{

	@Override
	public void onEvent(CacheEvent event) {
      System.out.println("Event Type of Cache " +event.getType()+" Key of cache "+event.getKey()+" Old value of cache "+event.getOldValue()+" New value of cache "+event.getNewValue());		
	}

}
