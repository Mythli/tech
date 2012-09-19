<?php
/**
 * Zend Framework (http://framework.zend.com/)
 *
 * @link      http://github.com/zendframework/ZendSkeletonApplication for the canonical source repository
 * @copyright Copyright (c) 2005-2012 Zend Technologies USA Inc. (http://www.zend.com)
 * @license   http://framework.zend.com/license/new-bsd New BSD License
 */

namespace zf2test\Controller;

use Zend\Mvc\Controller\AbstractActionController;
use Zend\View\Model\ViewModel;

class IndexController extends AbstractActionController
{
    private $greetingService;
    
    public function indexAction()
    {
        $greetingService = $this->getServiceLocator()->get('greetingService');
        
        return new ViewModel(array('greeting' => $greetingService->foo()));
    }
    
    public function setGreetingService($service)
    {
        $this->greetingService = $service;
    }
}
