-- ×Ô¶¨ÒåÃüÁîhmgetall
local result={};
for i,v in ipairs(KEYS) do
	result[i]=redis.call('hgetall',v);
end
return result;
