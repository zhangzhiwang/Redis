-- 在脚本中调用redis命令
--redis.call('set','name','aaa');
--local a=redis.call('get','name');
--print(a);

--redis.pcall('flushd');
--redis.pcall('set','name','aaa');

--return redis.call('flushdb');

--redis.call('set','name','aaa');
--return redis.call('get','name');

--return redis.call('exists','name');

--redis.call('lpush','name3','a','b');
--return redis.call('lrange','name3',0,-1);

return redis.call('get','sdf');
