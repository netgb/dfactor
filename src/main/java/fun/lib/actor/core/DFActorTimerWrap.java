package fun.lib.actor.core;

import fun.lib.actor.api.DFActorTimer;
import fun.lib.actor.api.cb.CbTimeout;

public final class DFActorTimerWrap implements DFActorTimer{
	
	private final int id;
	private final DFActorManager _mgr;
	
	protected DFActorTimerWrap(int id) {
		this.id = id;
		_mgr = DFActorManager.get();
	}
	
	@Override
	public void timeout(int delayMilli, int requestId) {
		_mgr.addTimeout(id, DFActor.transTimeRealToTimer(delayMilli), DFActorDefine.SUBJECT_TIMER, requestId, null);
	}

	@Override
	public void timeout(int delayMilli, CbTimeout cb) {
		_mgr.addTimeout(id, DFActor.transTimeRealToTimer(delayMilli), DFActorDefine.SUBJECT_TIMER, 0, cb);
	}

	@Override
	public long getTimeStart() {
		return _mgr.getTimerStartNano();
	}

	@Override
	public long getTimeNow() {
		return _mgr.getTimerNowNano();
	}

}
