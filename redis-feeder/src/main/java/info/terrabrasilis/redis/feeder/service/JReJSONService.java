package info.terrabrasilis.redis.feeder.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import info.terrabrasilis.redis.feeder.util.Path;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.jedis.util.SafeEncoder;

/**
 * 
 * @author jether
 *
 */
@Service
public class JReJSONService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7801408508546494907L;	
	
    @Autowired 
    @Qualifier("jedisToJReJSON")
    private Jedis connection;
    
	private Gson gson = new Gson();	

	/**
	 * 
	 * @author jether
	 * 
	 * 
	 */
    private enum Command implements ProtocolCommand {
        DEL("JSON.DEL"),
        GET("JSON.GET"),
        SET("JSON.SET"),
        TYPE("JSON.TYPE");
        private final byte[] raw;

        Command(String alt) {
            raw = SafeEncoder.encode(alt);
        }

        public byte[] getRaw() {
            return raw;
        }
    }

    /**
     * Existential modifier for the set command, by default we don't care
     */
    public enum ExistenceModifier implements ProtocolCommand {
        DEFAULT(""),
        NOT_EXISTS("NX"),
        MUST_EXIST("XX");
        private final byte[] raw;

        ExistenceModifier(String alt) {
            raw = SafeEncoder.encode(alt);
        }

        public byte[] getRaw() {
            return raw;
        }
    }

    /**
     * Helper to handle single optional path argument situations
     * @param path a single optional path
     * @return the provided path or root if not
     */
    private static Path getSingleOptionalPath(Path... path) {
        // check for 0, 1 or more paths
        if (1 > path.length)
            // default to root
            return Path.RootPath();
         else if (1 == path.length)
            // take 1
            return path[0];
         else
            // throw out the baby with the water
            throw new RuntimeException("Only a single optional path is allowed");
    }

    /**
     * Sets an object
     * @param conn the Jedis connection
     * @param key the key name
     * @param object the Java object to store
     * @param flag an existential modifier
     * @param path optional single path in the object, defaults to root
     */
    public void set(String key, Object object, ExistenceModifier flag, Path... path) {

        List<byte[]> args = new ArrayList<>(4);

        args.add(SafeEncoder.encode(key));
        args.add(SafeEncoder.encode(getSingleOptionalPath(path).toString()));
        args.add(SafeEncoder.encode(gson.toJson(object)));
        if (ExistenceModifier.DEFAULT != flag) {
            args.add(flag.getRaw());
        }

        this.connection.getClient().sendCommand(Command.SET, args.toArray(new byte[args.size()][]));
        
        this.connection.close();
        
    }

    /**
     * Sets an object without caring about target path existing
     * @param conn the Jedis connection
     * @param key the key name
     * @param object the Java object to store
     * @param path optional single path in the object, defaults to root
     */
    public void set(String key, Object object, Path... path) {
        set(key, object, ExistenceModifier.DEFAULT, path);
    }    
}
