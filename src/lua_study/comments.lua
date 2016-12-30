-- 单行注释
local a='name5'
--[[
多行
注释
]]
local b='aaa'
redis.call('set',a,b)