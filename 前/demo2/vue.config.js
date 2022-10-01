const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
   publicPath:'./',
 outputDir:'dist',
 
  transpileDependencies: true,
  devServer: {                 
    port: 8080,
    host:'127.0.0.1',
    proxy: {
           '/api':{  
                       //设置代理，必须填
             target: 'http://127.0.0.1:8081',     //代理的目标地址
             changeOrigin: true,              //是否设置同源，输入是的
            pathRewrite: {                   //路径重写
               // '^/api': '/api'
                '/api': ''                     //选择忽略拦截器里面的单词
            }
        }
    }
  }
})
