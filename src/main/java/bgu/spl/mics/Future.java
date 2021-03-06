package bgu.spl.mics;

import java.util.concurrent.TimeUnit;

/**
 * A Future object represents a promised result - an object that will
 * eventually be resolved to hold a result of some operation. The class allows
 * Retrieving the result once it is available.
 * 
 * Only private methods may be added to this class.
 * No public constructor is allowed except for the empty constructor.
 */
public class Future<T> {

	private T result;


	/**
	 * This should be the the only public constructor in this class.
	 */
	public Future() {
		//TODO: implement this
		result=null;

	}

	/**
     * retrieves the result the Future object holds if it has been resolved.
     * This is a blocking method! It waits for the computation in case it has
     * not been completed.
     * <p>
     * @return return the result of type T if it is available, if not wait until it is available.
     * 	       
     */
	public T get() {//Done, not sure if ok.
		//TODO: implement this.
		T res=get(30,TimeUnit.MICROSECONDS);//need to verify this
		if (res!=null) return res;
		else return null;
	}//shachar are you getting this? tralalala
	
	/**
     * Resolves the result of this Future object.
     */
	public void resolve (T result) { //Done. should be ok.
		//TODO: implement this.
		this.result=result;
	}

	
	/**
     * @return true if this object has been resolved, false otherwise
     */
	public boolean isDone() { //Done. should be ok.
		//TODO: implement this.
		if(result!=null)
			return true;
		else
			return false;
	}
	
	/**
     * retrieves the result the Future object holds if it has been resolved,
     * This method is non-blocking, it has a limited amount of time determined
     * by {@code timeout}
     * <p>
     * @param timeout 	the maximal amount of time units to wait for the result.
     * @param unit		the {@link TimeUnit} time units to wait.
     * @return return the result of type T if it is available, if not, 
     * 	       wait for {@code timeout} TimeUnits {@code unit}. If time has
     *         elapsed, return null.
     */
	public T get(long timeout, TimeUnit unit) {
		//TODO: implement this.
		while( unit.convert(timeout, unit)<timeout) {//possibly not how im supposed to do this,ask aviad/do this with sleep
			if (isDone())
				return result;
		}
				return null;
	}



}
