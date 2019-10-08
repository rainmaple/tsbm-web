-- 1.2 import line
-- 先查出来 然后再通过ID检索出名称
select tc.id,il.pps
from tsdb_config tc ,import_log il
where  il.w_id= (select max(id) from tsbm_test_batch where template_id=1 and cfg_id=tc.id)

-- 2.1/4.1 append bar 
select tmp.*,
(select clients from tsbm_write_result twr where twr.pps=tmp.pps and tmp.batch_id=twr.batch_id order by clients desc limit 1)  clients
from 
(select tc.id cfg_id,twr.batch_id,max(pps) pps,max(points_sum) sum,min(max_timeout) max_timeout,
min(min_timeout) min_timeout,min(avg_timeout) avg_timeout,min(th50_timeout) th50_timeout,min(th95_timeout) th95_timeout
from tsdb_config tc ,tsbm_write_result twr
where  twr.batch_id= (select max(id) from tsbm_test_batch where template_id=2 and cfg_id=tc.id)
group by tc.id,twr.batch_id) tmp

-- 2.2/4.2 append line 
select tc.id,twr.clients,twr.pps
from tsdb_config tc ,tsbm_write_result twr
where  twr.batch_id= (select max(id) from tsbm_test_batch where template_id=2 and cfg_id=tc.id)
order by tc.id

-- 3.1/5.1 append bar 
select tmp.*,
(select clients from tsbm_read_result twr where twr.qps=tmp.pps and tmp.batch_id=twr.batch_id order by clients desc limit 1)  clients
from 
(select tc.id cfg_id,twr.batch_id,max(qps) pps,max(query_sum) sum,min(max_timeout) max_timeout,
min(min_timeout) min_timeout,min(avg_timeout) avg_timeout,min(th50_timeout) th50_timeout,min(th95_timeout) th95_timeout
from tsdb_config tc ,tsbm_read_result twr
where  twr.batch_id= (select max(id) from tsbm_test_batch where template_id=2 and cfg_id=tc.id)
group by tc.id,twr.batch_id) tmp

-- 3.2/5.2 append line 
select tc.id,twr.clients,twr.qps
from tsdb_config tc ,tsbm_read_result twr
where  twr.batch_id= (select max(id) from tsbm_test_batch where template_id=2 and cfg_id=tc.id)
order by tc.id