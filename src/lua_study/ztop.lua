-- ×Ô¶¨ÒåÃüÁîztop
local element=redis.call('zrange',KEYS[1],0,0)[1];
return redis.call('zrem',KEYS[1],element);
