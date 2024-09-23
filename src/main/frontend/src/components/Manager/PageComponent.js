import React from 'react';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import { getList } from "../../api/ManagerApi";

const PageComponent = ({serverData, setManagers}) => {
  const movePage = async (pageParam) => {
    const data = await getList(pageParam);
    setManagers(data.dtoList);
  };

  return (
    <div className="m-6 flex flex-row justify-center">
    {serverData.prev ?
     <Box m={1} display="inline-block">
       <Button variant="contained" size="small" sx={{ backgroundColor: 'gray' }}
       onClick={() => movePage({page:serverData.prevPage} )}>
       Prev </Button>
     </Box> : <></>}

     {serverData.pageNumList.map(pageNum =>
     <Box m={1} display="inline-block" key={pageNum}>
       <Button variant="contained" size="small" sx={{ backgroundColor: 'gray' }}
       onClick={() => movePage( {page:pageNum})}>
       {pageNum}
       </Button>
     </Box>
      )}
   </div>
  );
}
export default PageComponent;