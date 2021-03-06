package fi.nsev.roadinfo.api.roadFluency.server

import fi.digitraffic.tie.sujuvuus.schemas.JourneyTimeResponse
import fi.nsev.roadinfo.api.roadFluency.common.JourneyTimeService
import fi.nsev.roadinfo.api.server.ApiController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class JourneyTimeController : ApiController{

    private val journeyTimeService: JourneyTimeService
    private val logger : Logger = LoggerFactory.getLogger(JourneyTimeController::class.java)

    @Autowired constructor(journeyTimeService: JourneyTimeService){
        this.journeyTimeService = journeyTimeService
    }

    @RequestMapping(value =  "/journeyTime", method = arrayOf(RequestMethod.GET))
    fun journeyTime(): JourneyTimeResponse {
        logger.debug("/journeyTime called")
        val journeyTimeResponse : JourneyTimeResponse = journeyTimeService.getJourneyTime()

        return journeyTimeResponse
    }
}