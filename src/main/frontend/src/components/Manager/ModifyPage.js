import { useNavigate } from "react-router-dom";


  const ModifyPage = ({userId}) => {
  const navigate = useNavigate()
  const moveToRead = () => {
   navigate({pathname:`/manager/read/${userId}`})
  }
  const moveToList = () => {
   navigate({pathname:`/manager/list`})
  }

  return (
   <div className="text-3xl font-extrabold"> Todo Modify Page </div>
   );
}

export default ModifyPage;
