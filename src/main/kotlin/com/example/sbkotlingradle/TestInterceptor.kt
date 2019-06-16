package com.example.sbkotlingradle

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.util.MimeType
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

class TestInterceptor : HandlerInterceptorAdapter() {
    @Throws(ServletException::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        val annot = (handler as HandlerMethod).getMethodAnnotation(CAnnotation::class.java)

        if (annot!=null) {
            println(annot.value)
            if (annot.value == 5) {
                response.status = 403
                response.contentType = "application/json"
                val json = ObjectMapper().writeValueAsString(object{
                    val error= "value is 5"
                })
                response.setContentLength(json.length)
                response.writer.print(json)
                response.writer.flush()
                response.writer.close()
//                response.sendError(403, "{}")
                return false
            }
        }
        return true
    }

    companion object {
        val KEY = "spring.internal.httpServletResponse"
    }
}

private operator fun HttpSession.set(s: String, value: Int) {
    this.setAttribute(s, value)
}
