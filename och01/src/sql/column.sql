select 'private ' ||decode(data_type,'NUMBER','int','VARCHAR2','String',data_type) ||' '||lower(column_name)||' '||
from cols where table_name='BOARD'
order by column_id;