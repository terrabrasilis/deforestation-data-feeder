package info.terrabrasilis.redis.feeder.response;

import java.io.Serializable;

import info.terrabrasilis.redis.feeder.dto.ResponseMessage;

/**
 * 
 * @author jether
 *
 */
public final class MessageResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6482658543365348475L;
	
	
	public static ResponseMessage CONTINUE = new ResponseMessage(100, "Continue");
	public static ResponseMessage COMUTATION_PROTOCOL = new ResponseMessage(101, "Comutation protocol");
	
	public static ResponseMessage OK = new ResponseMessage(200, "Ok");
	public static ResponseMessage CREATED = new ResponseMessage(201, "Created");
	public static ResponseMessage ACCEPTED = new ResponseMessage(202, "Accepted");
	public static ResponseMessage INFORMATION_NOT_ALLOWED = new ResponseMessage(203, "Information not allowed");
	public static ResponseMessage NO_CONTENT = new ResponseMessage(204, "No content");
	public static ResponseMessage REDEFINE_CONTENT = new ResponseMessage(205, "Redefine content");
	public static ResponseMessage PARTIAL_CONTENT = new ResponseMessage(206, "Parcial content");
	
	public static ResponseMessage MULTIPLE_CHOICES = new ResponseMessage(300, "Multiple choises");
	public static ResponseMessage PERMANETLY_MOVED = new ResponseMessage(301, "Permanetly moved");
	public static ResponseMessage FOUND = new ResponseMessage(302, "Found");
	public static ResponseMessage SEE_OTHERS = new ResponseMessage(303, "See others");
	public static ResponseMessage NOT_MODIFIED = new ResponseMessage(304, "Not modified");
	public static ResponseMessage USE_PROXY = new ResponseMessage(305, "Use a proxy");
	public static ResponseMessage NOT_USED = new ResponseMessage(306, "Not used");
	public static ResponseMessage TEMPORARILY_REDIRECT = new ResponseMessage(307, "Temporarily redirect");
	
	public static ResponseMessage BAD_REQUEST = new ResponseMessage(400, "Bad request");
	public static ResponseMessage NOT_ALLOWED = new ResponseMessage(401, "Not allowed");
	public static ResponseMessage REQUIRED = new ResponseMessage(402, "Required");
	public static ResponseMessage FORBIDDEN = new ResponseMessage(403, "Forbidden");
	public static ResponseMessage NOT_FOUND = new ResponseMessage(404, "Not found");
	public static ResponseMessage METHOD_NOT_ALLOWED = new ResponseMessage(405, "Method not allowed");
	public static ResponseMessage NOT_ACCEPTABLE = new ResponseMessage(406, "Not acceptable");
	public static ResponseMessage PROXY_AUTENTICATION_REQUIRED = new ResponseMessage(407, "Proxy autentication required");
	public static ResponseMessage REEQUISITION_TIME_LIMIT_EXCEEDED = new ResponseMessage(408, "Requisition time limit exceeded");
	public static ResponseMessage CONFLICT = new ResponseMessage(409, "Conflict");
	public static ResponseMessage CONSTRAINT_VIOLATION_RSP = new ResponseMessage(409, "Constraint violation");
	public static ResponseMessage DISAPPEARANCE = new ResponseMessage(410, "Disappearance");
	public static ResponseMessage LENGTH_REQUIRED = new ResponseMessage(411, "Length required");
	public static ResponseMessage PRE_CONDITION_FAILED = new ResponseMessage(412, "Pre condition failed");
	public static ResponseMessage REQUESTED_ENTITY_SO_MUCH_LARGE = new ResponseMessage(413, "Requested entity so much large");
	public static ResponseMessage URI_REQUESTED_SO_MUCH_LARGE = new ResponseMessage(414, "URI requested so much large");
	public static ResponseMessage MEDIA_TYPE_NOT_SUPPORTED = new ResponseMessage(415, "Media type not supported");
	public static ResponseMessage INTERVAL_REQUESTED_NOT_SATISFACTORY = new ResponseMessage(416, "Interval requested not satisfactory");
	public static ResponseMessage FAILURE_EXPECTATION = new ResponseMessage(417, "Failure expectation");
	
	public static ResponseMessage INTERNAL_SERVER_ERROR = new ResponseMessage(500, "Internal server error");
	public static ResponseMessage NOT_IMPLEMENTED = new ResponseMessage(501, "Not implemented");
	public static ResponseMessage BAD_EXIT_PORT = new ResponseMessage(502, "Bad exit port");
	public static ResponseMessage SERVICE_NOT_AVAILABLE = new ResponseMessage(503, "Service not available");
	public static ResponseMessage TIME_LIMIT_TO_EXIT_PORT = new ResponseMessage(504, "Time limit to exit port");
	public static ResponseMessage PROTOCOL_NOT_SUPPORTED = new ResponseMessage(505, "Protocol not supported");

}
