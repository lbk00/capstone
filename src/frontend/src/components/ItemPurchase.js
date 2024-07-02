import React, { useState } from 'react';

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';

import {
    Avatar,
    Box,
    Card,
    CardContent,
    CardMedia,
    Divider,
    Drawer,
    FormControl,
    Grid, Icon,
    InputLabel,
    List,
    ListItem,
    ListItemButton,
    ListItemIcon,
    ListItemText,
    Menu,
    MenuItem,
    OutlinedInput,
    Select,
} from '@mui/material';

export default function App() {
    const [anchorElUser, setAnchorElUser] = useState(null);
    const [anchorElProduct, setAnchorElProduct] = useState(null);
    const [anchorElOrdersheet, setAnchorElOrdersheet] = useState(null);
    const [anchorElInventory, setAnchorElInventory] = useState(null);
    const [anchorElSupplier, setAnchorElSupplier] = useState(null);

    const handleUserClick = (event) => {
        setAnchorElUser(event.currentTarget);
    };

    const handleProductClick = (event) => {
        setAnchorElProduct(event.currentTarget);
    };

    const handleOrdersheetClick = (event) => {
        setAnchorElOrdersheet(event.currentTarget);
    };

    const handleInventoryClick = (event) => {
        setAnchorElInventory(event.currentTarget);
    };

    const handleSupplierClick = (event) => {
        setAnchorElSupplier(event.currentTarget);
    };

    const handleCloseUser = () => {
        setAnchorElUser(null);
    };

    const handleCloseProduct = () => {
        setAnchorElProduct(null);
    };

    const handleCloseOrdersheet = () => {
        setAnchorElOrdersheet(null);
    };

    const handleCloseInventory = () => {
        setAnchorElInventory(null);
    };

    const handleCloseSupplier = () => {
        setAnchorElSupplier(null);
    };

    const openUser = Boolean(anchorElUser);
    const openProduct = Boolean(anchorElProduct);
    const openOrdersheet = Boolean(anchorElOrdersheet);
    const openInventory = Boolean(anchorElInventory);
    const openSupplier = Boolean(anchorElSupplier);

    const [open, setOpen] = React.useState(false);
    const toggleDrawer = (newOpen) => () => {
        setOpen(newOpen);
    };
    const DrawerList = (
        <Box sx={{ width: 250 }} role="presentation" onClick={toggleDrawer(false)}>
            <List>
                {['전체보기'].map((text, index) => (
                    <ListItem key={text} disablePadding>
                        <ListItemButton>
                            <ListItemIcon>
                                <MenuIcon />
                            </ListItemIcon>
                            <ListItemText primary={text} />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
            <Divider />
            <List>
                {['바지', '운동화', '트레이닝복', '티셔츠', '점퍼'].map((text, index) => (
                    <ListItem key={text} disablePadding>
                        <ListItemButton>
                            <ListItemIcon>
                                <MenuIcon />
                            </ListItemIcon>
                            <ListItemText primary={text} />
                        </ListItemButton>
                    </ListItem>
                ))}
            </List>
        </Box>
    );

    const [option1, setOption1] = React.useState('');
    const [option2, setOption2] = React.useState('');
    const [option3, setOption3] = React.useState('');

    const handleOption1Change = (event) => {
        setOption1(event.target.value);
    };

    const handleOption2Change = (event) => {
        setOption2(event.target.value);
    };

    const handleOption3Change = (event) => {
        setOption3(event.target.value);
    };

    return (
        <div className="App">
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black' }}>
                <Toolbar>
                    <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
                        <Icon sx={{ mr: 1 }} />
                    </IconButton>
                    <Typography align="left" variant="h6" sx={{ flexGrow: 1 }}>
                        메인페이지
                    </Typography>
                    <Avatar>Lee</Avatar>
                    <Button color="inherit">Login</Button>
                    <Button color="inherit">Sign up</Button>
                </Toolbar>
            </AppBar>
            <Divider />
            <AppBar position="static" sx={{ bgcolor: 'white', color: 'black'}}>
                <Toolbar>
                    <div>
                        <Button sx={{ color: 'black' }} onClick={toggleDrawer(true)}>
                            <MenuIcon/>
                        </Button>
                        <Drawer open={open} onClose={toggleDrawer(false)}>
                            {DrawerList}
                        </Drawer>
                    </div>

                    <Button sx={{ width : 90, color: 'black' }}>바지</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>운동화</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>트레이닝복</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>티셔츠</Button>
                    <Divider orientation="vertical" variant="middle" flexItem />
                    <Button sx={{ width : 90, color: 'black' }}>점퍼</Button>
                    <Box sx={{ flexGrow: 1 }} />
                    <form noValidate autoComplete="off">
                        <FormControl sx={{ width: '25ch', bgcolor: 'white' }} size="small">
                            <OutlinedInput
                                placeholder="검색어를 입력하세요"
                                sx={{
                                    '& .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px', // 테두리 두께를 1px로 고정
                                    },
                                    '&:hover .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                    '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                        borderColor: 'red',
                                        borderWidth: '2px',
                                    },
                                }}
                            />
                        </FormControl>
                    </form>
                </Toolbar>
            </AppBar>
            <Divider />
            {/*상품 상세 페이지*/}
            <Grid container spacing={0} justifyContent="center" alignItems="center">
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent>
                            <CardMedia
                                sx={{
                                    display: 'flex',
                                    justifyContent: 'center',
                                    alignItems: 'center',
                                    height: 500,
                                    width: 500 }}
                                image={require("./sample/sample1.jpg")}
                                title="sample1"
                            />
                        </CardContent>
                    </Card>
                </Grid>
                <Grid item xs={12} sm={6} md={4}>
                    <Card>
                        <CardContent sx={{ height: 500, width: 500 }}>
                            <Typography gutterBottom variant="h5" component="div">
                                상품이름
                            </Typography>
                            <Typography variant="h6" color="text.secondary">
                                ₩ 10000
                            </Typography>
                            <FormControl fullWidth sx={{ mt: 2 }}>
                                <InputLabel
                                    id="option1-label"
                                    sx={{
                                        color: 'gray',
                                        '&.Mui-focused': {
                                            color: 'gray',
                                        },
                                    }}
                                >
                                    선택
                                </InputLabel>
                                <Select
                                    labelId="option1-label"
                                    value={option1}
                                    label="옵션1"
                                    onChange={handleOption1Change}
                                    sx={{
                                        '& .MuiSelect-select': {
                                            color: 'gray',
                                        },
                                        '& .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                        '&:hover .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                        '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                    }}
                                >
                                    <MenuItem value={10}>상품1</MenuItem>
                                    <MenuItem value={20}>상품2</MenuItem>
                                    <MenuItem value={30}>상품3</MenuItem>
                                </Select>
                            </FormControl>
                            <FormControl fullWidth sx={{ mt: 2 }}>
                                <InputLabel
                                    id="option2-label"
                                    sx={{
                                        color: 'gray',
                                        '&.Mui-focused': {
                                            color: 'gray',
                                        },
                                    }}
                                >
                                    색상
                                </InputLabel>
                                <Select
                                    labelId="option2-label"
                                    value={option2}
                                    label="옵션2"
                                    onChange={handleOption2Change}
                                    sx={{
                                        '& .MuiSelect-select': {
                                            color: 'gray',
                                        },
                                        '& .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                        '&:hover .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                        '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                    }}
                                >
                                    <MenuItem value={10}>흰색</MenuItem>
                                    <MenuItem value={20}>검정색</MenuItem>
                                    <MenuItem value={30}>파랑색</MenuItem>
                                </Select>
                            </FormControl>
                            <FormControl fullWidth sx={{ mt: 2 }}>
                                <InputLabel
                                    id="option3-label"
                                    sx={{
                                        color: 'gray',
                                        '&.Mui-focused': {
                                            color: 'gray',
                                        },
                                    }}
                                >
                                    사이즈
                                </InputLabel>
                                <Select
                                    labelId="option3-label"
                                    value={option3}
                                    label="옵션3"
                                    onChange={handleOption3Change}
                                    sx={{
                                        '& .MuiSelect-select': {
                                            color: 'gray',
                                        },
                                        '& .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                        '&:hover .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                        '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                            borderColor: 'gray',
                                        },
                                    }}
                                >
                                    <MenuItem value={10}>XL</MenuItem>
                                    <MenuItem value={20}>L</MenuItem>
                                    <MenuItem value={30}>M</MenuItem>
                                </Select>
                            </FormControl>
                            <Grid container spacing={2} sx={{ mt: 2 }}>
                                <Grid item>
                                    <Button
                                        variant="contained"
                                        sx={{
                                            bgcolor: 'gray',
                                            color: 'white',
                                            '&:hover': { bgcolor: 'gray' },
                                        }}
                                    >
                                        구매하기
                                    </Button>
                                </Grid>
                                <Grid item>
                                    <Button
                                        variant="outlined"
                                        sx={{
                                            borderColor: 'gray',
                                            color: 'gray',
                                            '&:hover': {
                                                borderColor: 'gray',
                                                color: 'gray',
                                            },
                                        }}
                                    >
                                        장바구니
                                    </Button>
                                </Grid>
                            </Grid>
                        </CardContent>
                    </Card>
                </Grid>
            </Grid>
            <AppBar position="static" sx={{ bgcolor: 'gray', color: 'black', height: 50 }}>
                <Toolbar></Toolbar>
            </AppBar>
        </div>
    );
}
